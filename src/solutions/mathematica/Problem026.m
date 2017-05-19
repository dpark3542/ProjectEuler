(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-17 *)

First@MaximalBy[Range[999],RealDigits[1/#][[1,-1]]&]