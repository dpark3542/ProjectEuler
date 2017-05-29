(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-29 *)

ClearAll[s,f];
s[0]=0;
s[i_]:=s[i]=s[i-1]+Prime[i];
Do[s[i],{i,PrimePi[1000000]}]
f[{x_,y_}]:=s[x+y]-s[x-1]
f@NestWhile[If[Total[#]+1<=PrimePi[1000000],#+{1,0},{1,Last[#]-1}]&,{1,SelectFirst[Range@PrimePi[1000000],s[#]>=1000000&]-2},f[#]>=1000000||!PrimeQ@f[#]&]