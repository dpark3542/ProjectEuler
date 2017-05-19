(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-14 *)

n (n+1)/2/.n->NestWhile[#+1&,1,DivisorSigma[0,# (#+1)/2]<=500&]