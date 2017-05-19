(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-14 *)

ClearAll[cl];
cl[1]=1;
cl[n_]:=cl[n]=If[EvenQ[n],cl[n/2],cl[3n+1]]+1
First@MaximalBy[Range[1000000], cl]