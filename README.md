# ```FlutterEngine``` error on hot restart(Android only)
This repo is the sample code to reproduce error that is described in [issue](https://github.com/flutter/flutter/issues/114005).
There are two different ```FlutterEngine``` from the same ```FlutterEngineGroup``` and I'm using ```SendPort``` to communicate between the engines. It works fine in the very first build even though I send the class instances that I have made. But after hot restart, I get error like below in SendPort.send(Data()) and only basic dart types are allowed(int, String...).
```
Invalid argument(s): Illegal argument in isolate message : (object is a regular Dart Instance)
```
## Expected Behavior
First build before hot restart
```
I/flutter (21335): REQUEST from ActivityEngine::: 1
I/flutter (21335): RESPONSE from ApplicationEngine::: 2
```
After hot restart
```
I/flutter (21335): REQUEST from ActivityEngine::: 1
I/flutter (21335): RESPONSE from ApplicationEngine::: 2
```
## Actual Behavior
First build before hot restart
```
I/flutter (21335): REQUEST from ActivityEngine::: 1
I/flutter (21335): RESPONSE from ApplicationEngine::: 2
```
```
I/flutter (21335): REQUEST from ActivityEngine::: 1
I/flutter (21335): Invalid argument(s): Illegal argument in isolate message : (object is a regular Dart Instance) #0      _SendPortImpl._sendInternal (dart:isolate-patch/isolate_patch.dart:249:43)
```