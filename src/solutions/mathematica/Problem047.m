(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-28 *)

NestWhile[#+1&,1,!PrimeNu[#]==PrimeNu[#+1]==PrimeNu[#+2]==PrimeNu[#+3]==4&]