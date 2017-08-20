(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-07-19 *)

Length@Select[FromContinuedFraction/@(ContinuedFraction[Sqrt[2],#]&/@Range[1000]),IntegerLength@Numerator[#]>IntegerLength@Denominator[#]&]