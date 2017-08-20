(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-06-01 *)

NestWhile[#+9&,9,!Equal@@(Sort@IntegerDigits[#]&/@(Range[6]*#))&]