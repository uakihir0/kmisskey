#!/usr/bin/env bash
cd "$(dirname "$0")" || exit
BASE_PATH=$(pwd)
BUILD_PATH=../all/build

# Make Repository
cd "$BASE_PATH" || exit
mkdir -p $BUILD_PATH/cocoapods/repository/debug
mkdir -p $BUILD_PATH/cocoapods/repository/release

# Copy Podspec
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/debug || exit
cp kmisskey.podspec ../../repository/kmisskey-debug.podspec
cd ../../repository/ || exit
sed -i -e "s|'kmisskey'|'kmisskey-debug'|g" kmisskey-debug.podspec
sed -i -e "s|'kmisskey.xcframework'|'debug/kmisskey.xcframework'|g" kmisskey-debug.podspec
rm *.podspec-e
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/release || exit
cp kmisskey.podspec ../../repository/kmisskey-release.podspec
cd ../../repository/ || exit
sed -i -e "s|'kmisskey'|'kmisskey-release'|g" kmisskey-release.podspec
sed -i -e "s|'kmisskey.xcframework'|'release/kmisskey.xcframework'|g" kmisskey-release.podspec
rm *.podspec-e

# Copy Framework
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/debug || exit
cp -r kmisskey.xcframework ../../repository/debug/kmisskey.xcframework
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/release || exit
cp -r kmisskey.xcframework ../../repository/release/kmisskey.xcframework

# Copy README
cd "$BASE_PATH" || exit
cd ../ || exit
cp ./LICENSE ./all/build/cocoapods/repository/LICENSE
cp ./docs/pods/README.md ./all/build/cocoapods/repository/README.md
cp ./docs/pods/README_ja.md ./all/build/cocoapods/repository/README_ja.md
