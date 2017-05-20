(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-19 *)

Denominator[Times@@(a/b/.Solve[(a/b==Floor[a/10]/Mod[b,10]&&Mod[a,10]==Floor[b/10]||a/b==Mod[a,10]/Floor[b/10]&&Floor[a/10]==Mod[b,10])&&10<=a<b<100,{a,b},Integers])]