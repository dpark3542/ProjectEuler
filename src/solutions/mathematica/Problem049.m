(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-28 *)

Total[SelectFirst[Through[{First,Mean,Last}[#]]&/@Subsets[Prime@Range[PrimePi[1000]+1,PrimePi[9999]],{2}],PrimeQ[#[[2]]]&&Equal@@(Sort/@IntegerDigits/@#)&&#!={1487,4817,8147}&]*{10^8,10^4,1}]