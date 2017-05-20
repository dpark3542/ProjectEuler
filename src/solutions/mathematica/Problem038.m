(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-19 *)

Max[FromDigits/@Select[Flatten@IntegerDigits@NestWhile[Append[#,Last[#]+#]&,{#},Total[IntegerLength/@#]<9&]&/@Range[10000],Sort[#]==Range[9]&]]