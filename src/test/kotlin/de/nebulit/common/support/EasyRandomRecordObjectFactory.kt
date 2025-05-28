package de.nebulit.common.support
import java.lang.reflect.Constructor
import org.jeasy.random.EasyRandom
import org.jeasy.random.ObjectCreationException
import org.jeasy.random.ObjenesisObjectFactory
import org.jeasy.random.api.RandomizerContext

// see: https://github.com/j-easy/easy-random/issues/397
class EasyRandomRecordObjectFactory : ObjenesisObjectFactory() {
    private var easyRandom: EasyRandom? = null

    override fun <T> createInstance(type: Class<T>, context: RandomizerContext): T {
        if (easyRandom == null) {
            easyRandom = EasyRandom(context.parameters)
        }

        return if (type.isRecord) {
            createRandomRecord(type)
        } else {
            super.createInstance(type, context)
        }
    }

    private fun <T> createRandomRecord(recordType: Class<T>): T {
        // generate random values for record components
        val recordComponents = recordType.recordComponents
        val randomValues = arrayOfNulls<Any>(recordComponents.size)
        for (i in recordComponents.indices) {
            randomValues[i] = easyRandom!!.nextObject(recordComponents[i].type)
        }
        // create a random instance with random values
        try {
            return getCanonicalConstructor(recordType).newInstance(*randomValues)
        } catch (e: Exception) {
            throw ObjectCreationException("Unable to create a random instance of recordType $recordType", e)
        }
    }

    private fun <T> getCanonicalConstructor(recordType: Class<T>): Constructor<T> {
        val recordComponents = recordType.recordComponents
        val componentTypes: Array<Class<*>?> = arrayOfNulls(recordComponents.size)
        for (i in recordComponents.indices) {
            // recordComponents are ordered, see javadoc:
            // "The components are returned in the same order that they are declared in the record header"
            componentTypes[i] = recordComponents[i].type
        }
        try {
            return recordType.getDeclaredConstructor(*componentTypes)
        } catch (e: NoSuchMethodException) {
            // should not happen, from Record javadoc:
            // "A record class has the following mandated members: a public canonical constructor ,
            // whose descriptor is the same as the record descriptor;"
            throw RuntimeException("Invalid record definition", e)
        }
    }
}