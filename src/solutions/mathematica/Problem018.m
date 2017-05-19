(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-14 *)

ClearAll[raw];
raw=Import[FileNameJoin[{NestWhile[ParentDirectory,NotebookDirectory[],FileBaseName[#]!="ProjectEuler"&],"src/input/p018_triangle.txt"}]];
Max@Fold[Max/@Transpose[{Append[#1,0],Prepend[#1,0]}]+#2&,ToExpression[StringSplit[#," "]&/@StringSplit[raw,"\n"]]]