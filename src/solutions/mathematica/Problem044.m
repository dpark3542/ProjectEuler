(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-22 *)

ClearAll[p];
p[n_]:=n (3n-1)/2;
p@NestWhile[#+1&,1,Solve[p[k]-p[j]==p[#]&&p[k]+p[j]==p[l]&&l>k>j>0,{j,k,l},Integers]=={}&]