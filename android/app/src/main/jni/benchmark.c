#include<jni.h>

int isPrime(long n) {
    if (n < 2) return 0;

    for (long i = 2; i * i <= n; i++) {
        if (n % i == 0) return 0;
    }

    return 1;
}

static long getNthPrimeNumber(int n) {
    int counter = 0;

    for (long i = 1;; i++) {
        if (isPrime(i))
            counter++;

        if (counter == n) {
            return i;
        }
    }
}

JNIEXPORT jlong JNICALL
Java_com_nabinbhandari_flutterbenchmark_TestActivity_nativeGetNthPrimeNumber(JNIEnv *env,
                                                                             jclass type, jint n) {
    return getNthPrimeNumber(n);
}
