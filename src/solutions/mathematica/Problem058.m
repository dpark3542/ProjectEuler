(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-07-19 *)

2n-1/.n->First@NestWhile[{First[#]+1,Last[#]+Count[{4n^2-6n+3,4n^2-8n+5,4n^2-10n+7}/.n->First[#]+1,_?PrimeQ]}&,{2,3},Last[#]/(4First[#]-3)>=0.1&]