(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-19 *)

Length@Select[Range[1000000-1],FreeQ[IntegerDigits[#],0]&&And@@PrimeQ[FromDigits/@NestList[RotateRight,IntegerDigits[#],IntegerLength[#]-1]]&]