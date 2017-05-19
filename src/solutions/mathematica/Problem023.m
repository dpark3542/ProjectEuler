(* Mathematica Source File  *)
(* Created by Mathematica Plugin for IntelliJ IDEA *)
(* :Author: dpark3542 *)
(* :Date: 2017-05-15 *)

28123*28124/2-Total[Select[DeleteDuplicates[Total/@Tuples[Select[Range[28123],DivisorSigma[1,#]>2#&],2]],#<=28123&]]