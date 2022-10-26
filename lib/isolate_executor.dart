import 'dart:isolate';
import 'dart:ui';

const String applicationEngineSendPortKey = 'applicationEngineSendPort';

SendPort setActivityEngineReceiver() {
  ReceivePort receivePort = ReceivePort();
  receivePort.listen((data) async {
    print("RESPONSE from ApplicationEngine::: ${data.value}");
  });
  return receivePort.sendPort;
}

SendPort setApplicationEngineReceiver() {
  ReceivePort receivePort = ReceivePort();
  receivePort.listen((data) async {
    print("REQUEST from ActivityEngine::: ${data.value}");
    int value = data.value;
    SendPort responseSendPort = data.responseSendPort;

    try {
      responseSendPort.send(Data(value: value * 2));
    } catch (e, s) {
      print('$e $s');
    }
  });
  return receivePort.sendPort;
}

class Data {
  Data({required this.value, this.responseSendPort});
  final int value;
  SendPort? responseSendPort;
}
