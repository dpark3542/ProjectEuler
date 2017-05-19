(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-17 *)

NestWhile[#+1&,1,IntegerLength[Fibonacci[#]]<1000&]