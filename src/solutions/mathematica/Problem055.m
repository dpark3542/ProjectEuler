(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-07-19 *)

10000-Count[NestWhile[#+IntegerReverse[#]&,#+IntegerReverse[#],!PalindromeQ[#]&,1,48]&/@Range[10000],_?PalindromeQ]