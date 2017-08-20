(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-15 *)

Count[Outer[DayName[{#1,#2,1}]&,Range[1901,2000],Range[12]],Sunday,2]