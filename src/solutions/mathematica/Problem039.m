(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-19 *)

First@Commonest[a+b+c/.Solve[a+b+c<=1000&&a^2+b^2==c^2&&c>b>=a>0,{a,b,c},Integers]]