# Flutter Benchmark

A test project to test performance of Java, C and Dart (Flutter) in Android device.

## Implementation

To benchmark the performance, I chose a simple algorithm to calculate nth prime number from [stackoverflow](https://stackoverflow.com/a/9625716/5137352) and wrote the same algorithm in Java, C and Dart.

## Results

The app was tested in both debug and release mode. The results were found to be similar for Java and C in both modes, but it was surprisingly different for Flutter. The time required to calculate the **20000th prime number** in my phone (Moto G5 Plus) for different cases are given below:

|                |Debug Mode                     |Release Mode                 |
|----------------|-------------------------------|-----------------------------|
|Java            |1131 ms                        |1128 ms                      |
|C               |408 ms                         |311 ms                       |
|Dart (Flutter)   |`106 ms`                       |`821 ms`                     |

 **Notes:**
 - Android NDK has been used to build the source code in C.
 - This test reflects the performance only for user-defined functions. The library functions of Android are optimized and most of them are already written in C/C++.
