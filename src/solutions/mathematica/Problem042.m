(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-20 *)

ClearAll[raw];
raw=Import[FileNameJoin[{NestWhile[ParentDirectory,NotebookDirectory[],FileBaseName[#]!="ProjectEuler"&],"src/input/p042_words.txt"}]];
Length@Select[Total/@Characters@ToExpression["{"<>raw<>"}"]/.Inner[Rule,CharacterRange["A","Z"],Range[26],List],IntegerQ[(Sqrt[1+8#]-1)/2]&]