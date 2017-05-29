(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-20 *)

Total[FromDigits/@Select[Permutations[Range[0,9]][[9!+1;;]],Inner[Divisible,FromDigits/@Partition[#,3,1][[2;;8]],Prime@Range[7],And]&]]