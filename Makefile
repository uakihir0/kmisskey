build:
	./gradlew \
	core:clean stream:clean \
	core:assemble stream:assemble \
	-x test --refresh-dependencies

pods:
	./gradlew \
	all:assembleKmisskeyXCFramework \
	all:podPublishXCFramework \
	-x test --refresh-dependencies

version:
	 ./gradlew version --no-daemon --console=plain -q

.PHONY: build pods version