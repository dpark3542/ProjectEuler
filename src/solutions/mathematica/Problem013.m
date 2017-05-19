(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-14 *)

ClearAll[raw];
raw=Import[FileNameJoin[{NestWhile[ParentDirectory,NotebookDirectory[],FileBaseName[#]!="ProjectEuler"&],"src/input/p013_numbers.txt"}]];
FromDigits@IntegerDigits[Total@ToExpression@StringSplit[raw,"\n"]][[;;10]]