(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-15 *)

ClearAll[raw];
raw=Import[FileNameJoin[{NestWhile[ParentDirectory,NotebookDirectory[],FileBaseName[#]!="ProjectEuler"&],"src/input/p022_names.txt"}]];
Total@MapIndexed[First[#2]#1&,Total/@Characters@Sort@ToExpression["{"<>raw<>"}"]/.Inner[Rule,CharacterRange["A","Z"],Range[26],List]]