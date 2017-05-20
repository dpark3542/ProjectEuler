(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-19 *)

ClearAll[n,l];
n=11;
l={};
While[Length[l]<11,If[And@@PrimeQ@Join[FoldList[10#1+#2&,IntegerDigits[n]],IntegerReverse@FoldList[10#1+#2&,Most@Reverse@IntegerDigits[n]]],AppendTo[l,n]];n=NextPrime[n]];
Total[l]