(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-14 *)

ClearAll[raw,g];
raw=Import[FileNameJoin[{NestWhile[ParentDirectory,NotebookDirectory[],FileBaseName[#]!="ProjectEuler"&],"src/input/p011_grid.txt"}]];
g=Partition[ToExpression@StringSplit[raw," "|"\n"],20];
Max[Times@@@Flatten[Partition[#,4,1]&/@Join[g,Transpose[g],Diagonal[g,#]&/@Range[-20+4,20-4],Diagonal[Reverse[g],#]&/@Range[-20+4,20-4]],1]]
