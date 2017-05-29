(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-22 *)

NestWhile[#+2&,1,!CompositeQ[#]||Solve[#==p+2*a^2&&p\[Element]Primes&&a>0,{p,a},Integers]!={}&]