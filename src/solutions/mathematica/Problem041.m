(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-20 *)

SelectFirst[FromDigits/@Flatten[Reverse@Permutations@Range[#]&/@Range[7,1,-1],1],PrimeQ]