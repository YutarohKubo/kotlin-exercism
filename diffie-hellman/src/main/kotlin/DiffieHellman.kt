import java.math.BigInteger
import kotlin.random.Random
import kotlin.random.nextInt

object DiffieHellman {

    fun privateKey(prime: BigInteger): BigInteger {
        return Random.nextInt(1..prime.toInt()).toBigInteger()
    }

    fun publicKey(p: BigInteger, g: BigInteger, privKey: BigInteger): BigInteger {
        return g.pow(privKey.toInt()) % p
    }

    fun secret(prime: BigInteger, publicKey: BigInteger, privateKey: BigInteger): BigInteger {
        return publicKey.pow(privateKey.toInt()) % prime
    }
}
