(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-14 *)

StringCount[StringJoin@@(StringReplace[IntegerName[#,"Words"],{"hundred "->"hundred and "}]&/@Range[1000]),LetterCharacter]