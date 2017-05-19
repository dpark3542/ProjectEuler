(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-14 *)

ClearAll[raw];
raw=Import[FileNameJoin[{NestWhile[ParentDirectory,NotebookDirectory[],FileBaseName[#]!="ProjectEuler"&],"src/input/p008_string.txt"}]];
Max[Times@@@Partition[IntegerDigits@ToExpression@StringDelete[raw,"\n"],13,1]]