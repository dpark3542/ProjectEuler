(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-18 *)

Times@@Flatten@MaximalBy[Flatten[Outer[List,Range[-999,999],Range[-1000,1000]],1],Function[{a,b},NestWhile[#+1&,1,PrimeQ[#^2+a #+b]&]]@@#&]