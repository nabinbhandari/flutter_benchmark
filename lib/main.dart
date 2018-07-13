import 'package:flutter/material.dart';

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'Flutter Benchmark',
      theme: new ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: new MyPage(),
    );
  }
}

class MyPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final key = GlobalKey<ScaffoldState>();
    return Scaffold(
      key: key,
      appBar: AppBar(title: Text("Flutter")),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              RaisedButton(
                child: Text("Test"),
                onPressed: () {
                  int n = 20000;
                  int startTime = new DateTime.now().millisecondsSinceEpoch;
                  int result = nThPrimeNumber(n);
                  int elapsed =
                      new DateTime.now().millisecondsSinceEpoch - startTime;

                  String text = "${n}th prime number: $result \ntime: $elapsed";
                  print(text);
                  key.currentState.showSnackBar(SnackBar(content: Text(text)));
                },
              )
            ],
          )
        ],
      ),
    );
  }

  int nThPrimeNumber(int n) {
    int counter = 0;

    for (var i = 1;; i++) {
      if (isPrime(i)) counter++;

      if (counter == n) {
        return i;
      }
    }
  }

  bool isPrime(var n) {
    if (n < 2) return false;

    for (var i = 2; i * i <= n; i++) {
      if (n % i == 0) return false;
    }

    return true;
  }
}
