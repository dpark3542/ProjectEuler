(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-14 *)

Total@Select[Range[999],Divisible[#,3]||Divisible[#,5]&]