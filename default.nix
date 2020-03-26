{ pkgs ? import <nixpkgs> {} }:
{
 dev-shell = pkgs.stdenv.mkDerivation {
  name = "dev-shell";

  buildInputs = [
   pkgs.boot
   pkgs.phantomjs2
   pkgs.gnupg1
  ];
 };
}
