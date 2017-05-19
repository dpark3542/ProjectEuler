(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-15 *)

ClearAll[d];
d[n_]:=DivisorSigma[1,n]-n;
Total@Select[Range[10000],d[#]!=#&&d[d[#]]==#&]