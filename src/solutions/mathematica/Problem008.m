(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-14 *)

raw = Import[FileNameJoin[{NestWhile[ParentDirectory,NotebookDirectory[],FileBaseName[#]!="ProjectEuler"&],"src/input/p008_string"}]];

Max[Times@@@Partition[Flatten@IntegerDigits@raw,13,1]]