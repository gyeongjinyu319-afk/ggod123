# 🥔 Holy Grail War Plugin

마인크래프트 Paper 서버 플러그인: **감자교 vs 고구마교 성배전쟁**

## 📋 기능

### 🎮 핵심 기능
- **진영 시스템**: 감자교 또는 고구마교 선택
- **화폐 시스템**: 감자코인, 고구마토큰, 로또
- **축복/저주 시스템**: 능력 강화 및 약화
- **교황 선정**: 투표를 통한 교황 선정 및 특별 권한
- **성배 시스템**: 소원 시스템

### ⚡ 이벤트 시스템
- 비 이벤트
- 번개 이벤트
- UFO 이벤트
- 바이러스 이벤트

### 🎭 NPC & 상호작용
- 고급 NPC 시스템
- 퀘스트 및 리워드

## 🚀 설치 방법

### 요구사항
- Paper 1.20.1 이상
- Java 11 이상
- Maven (빌드용)

### 설치 단계

1. **저장소 클론**
   ```bash
   git clone https://github.com/gyeongjinyu319-afk/ggod123.git
   cd ggod123
   ```

2. **Maven으로 빌드**
   ```bash
   mvn clean package
   ```

3. **JAR 파일 배포**
   생성된 `target/HolyGrailWar-1.0.jar` 파일을 서버의 `plugins` 폴더에 복사합니다.

4. **서버 재시작**
   ```bash
   ./start.sh
   ```
   또는 서버 콘솔에서:
   ```
   reload
   ```

## 📖 사용 방법

### 기본 명령어

#### 감자교
```
/감자 입교              - 감자교에 입교
/감자 상태              - 상태 확인
/감자 헌금 [금액]       - 헌금
```

#### 고구마교
```
/고구마 입교            - 고구마교에 입교
/고구마 상태            - 상태 확인
/고구마 헌금 [금액]     - 헌금
```

#### 성배
```
/성배 상태              - 성배 상태 확인
/성배 소원 [내용]       - 성배에 소원을 빕니다
```

#### 축복/저주
```
/축복 [플레이어]        - 플레이어에게 축복을 부여 (10분)
/저주 [플레이어]        - 플레이어에게 저주를 부여 (5분)
```

#### 기타
```
/교황 투표 [이름]       - 교황 후보에 투표
/교황 결과              - 교황 선정 결과
/화폐 [플레이어]        - 화폐 조회
/통계                   - 전쟁 통계
```

## ⚙️ 설정

`config.yml` 파일에서 다음을 설정할 수 있습니다:

```yaml
# 게임 난이도
game:
  difficulty: hard
  mode: ffa

# 진영 최대 인원
factions:
  potato:
    max_members: 30
  sweet_potato:
    max_members: 30

# 축복 지속 시간
blessings:
  duration: 600  # 초 단위

# 교황 임기
pope:
  duration: 1800  # 30분

# 이벤트 활성화
events:
  rain: true
  lightning: true
  ufo: true
  virus: true
```

## 🎨 커스터마이징

### 새로운 진영 추가

1. `FactionManager.java` 수정
2. `config.yml`에 진영 정보 추가
3. 새로운 커맨드 클래스 생성

### 새로운 이벤트 추가

1. `EntityEventListener.java`에 이벤트 핸들러 추가
2. 이벤트 로직 구현

## 🐛 버그 리포트

문제를 발견하면 [Issues](https://github.com/gyeongjinyu319-afk/ggod123/issues)에 등록해주세요.

## 📝 라이센스

MIT License

## 👨‍💻 개발자

- **gyeongjinyu319** - 주 개발자

## 🙏 기여

Pull Request를 환영합니다!

---

**성배전쟁에서 당신의 진영을 선택하고 승리하세요! 🥔🍠**
