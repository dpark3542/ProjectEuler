(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-14 *)

SelectFirst[Reverse@Sort[Times@@@Tuples[Range[100,999],2]],PalindromeQ]