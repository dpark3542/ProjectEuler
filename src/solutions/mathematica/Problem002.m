(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-14 *)

Total@Select[Fibonacci/@NestWhileList[#+1&,1,Fibonacci[#]<4000000&],EvenQ]