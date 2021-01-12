{ pkgs ? import <nixpkgs> {} }:
{
 dev-shell = pkgs.stdenv.mkDerivation {
  name = "dev-shell";

  shellHook = ''
  export JAVA_TOOL_OPTIONS=-Djdk.launcher.addmods=java.xml.bind
  '';

  buildInputs = [
   pkgs.boot
   pkgs.phantomjs2
   pkgs.gnupg1
  ];
 };
}
