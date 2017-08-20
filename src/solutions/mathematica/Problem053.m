(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-07-19 *)

Count[Binomial[#,Range[0,#]]&/@Range[100]-1000000,_?Positive,2]