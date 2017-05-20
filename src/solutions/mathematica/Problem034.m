(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-19 *)

Total@Select[Range[10,1000000],#==Total[IntegerDigits[#]!]&]