#!/usr/bin/env bash
cd "$(dirname "$0")" || exit
BASE_PATH=$(pwd)
BUILD_PATH=../pods/build/dist/js/developmentLibrary

# Make Ignore Files
# cd "$BASE_PATH" || exit
# cd "$BUILD_PATH" || exit
# touch .gitignore
# echo "node_modules" >> .gitignore
# touch .npmignore
# echo "node_modules" >> .npmignore

# Copy README
cd "$BASE_PATH" || exit
cp ../LICENSE $BUILD_PATH/LICENSE
cp ../docs/js/README.md $BUILD_PATH/README.md
cp ../docs/js/README_ja.md $BUILD_PATH/README_ja.md

# Wrapping type to Promise (kmisskey-js.d.ts)
cd "$BASE_PATH" || exit
cd "$BUILD_PATH" || exit
sed -i -e "s|): work\(.*\)>;|): Promise<work\1>>;|g" kmisskey-js.d.ts
rm kmisskey-js.d.ts-e
