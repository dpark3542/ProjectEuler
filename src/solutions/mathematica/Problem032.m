(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-19 *)

Total@DeleteDuplicates[Last/@Select[Flatten[Join[Outer[{#1,#2,#1*#2}&,Range[9],Range[1000,9999]],Outer[{#1,#2,#1*#2}&,Range[10,99],Range[100,999]]],1],Sort[Join@@IntegerDigits/@#]==Range[9]&]]