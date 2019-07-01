package com.jangho.convh265.model

class MediainfoTestResult {

    companion object {
        val h265Result = """
General
Unique ID                                : 154709714639845480454331344383979959567 (0x746401D898AB7F74BB6BE79E7DCA350F)
Complete name                            : test.cut.265.crf.mkv
Format                                   : Matroska
Format version                           : Version 4
File size                                : 9.81 MiB
Duration                                 : 1 min 0 s
Overall bit rate                         : 1 370 kb/s
Writing application                      : Lavf58.27.103
Writing library                          : Lavf58.27.103
ErrorDetectionType                       : Per level 1

Video
ID                                       : 1
Format                                   : HEVC
Format/Info                              : High Efficiency Video Coding
Format profile                           : Main 10@L4@Main
Codec ID                                 : V_MPEGH/ISO/HEVC
Duration                                 : 1 min 0 s
Bit rate                                 : 2 281 kb/s
Width                                    : 1 920 pixels
Height                                   : 1 080 pixels
Display aspect ratio                     : 16:9
Frame rate mode                          : Variable
Frame rate                               : 599.011 FPS
Original frame rate                      : 23.976 (24000/1001) FPS
Color space                              : YUV
Chroma subsampling                       : 4:2:0
Bit depth                                : 10 bits
Bits/(Pixel*Frame)                       : 0.002
Stream size                              : 408 MiB
Writing library                          : x265 3.0_Au+30-b9bef1a4c34a:[Windows][GCC 8.3.1][64 bit] 10bit
Encoding settings                        : cpuid=1111039 / frame-threads=3 / numa-pools=8 / wpp / no-pmode / no-pme / no-psnr / no-ssim / log-level=2 / input-csp=1 / input-res=1920x1080 / interlace=0 / total-frames=0 / level-idc=0 / high-tier=1 / uhd-bd=0 / ref=3 / no-allow-non-conformance / no-repeat-headers / annexb / no-aud / no-hrd / info / hash=0 / no-temporal-layers / open-gop / min-keyint=23 / keyint=250 / gop-lookahead=0 / bframes=4 / b-adapt=2 / b-pyramid / bframe-bias=0 / rc-lookahead=20 / lookahead-slices=6 / scenecut=40 / radl=0 / no-splice / no-intra-refresh / ctu=64 / min-cu-size=8 / no-rect / no-amp / max-tu-size=32 / tu-inter-depth=1 / tu-intra-depth=1 / limit-tu=0 / rdoq-level=0 / dynamic-rd=0.00 / no-ssim-rd / signhide / no-tskip / nr-intra=0 / nr-inter=0 / no-constrained-intra / strong-intra-smoothing / max-merge=2 / limit-refs=3 / no-limit-modes / me=1 / subme=2 / merange=57 / temporal-mvp / weightp / no-weightb / no-analyze-src-pics / deblock=0:0 / sao / no-sao-non-deblock / rd=3 / no-early-skip / rskip / no-fast-intra / no-tskip-fast / no-cu-lossless / no-b-intra / no-splitrd-skip / rdpenalty=0 / psy-rd=2.00 / psy-rdoq=0.00 / no-rd-refine / no-lossless / cbqpoffs=0 / crqpoffs=0 / rc=crf / crf=28.0 / qcomp=0.60 / qpstep=4 / stats-write=0 / stats-read=0 / ipratio=1.40 / pbratio=1.30 / aq-mode=2 / aq-strength=1.00 / cutree / zone-count=0 / no-strict-cbr / qg-size=32 / no-rc-grain / qpmax=69 / qpmin=0 / no-const-vbv / sar=1 / overscan=0 / videoformat=5 / range=0 / colorprim=2 / transfer=2 / colormatrix=2 / chromaloc=0 / display-window=0cll=0,0 / min-luma=0 / max-luma=1023 / log2-max-poc-lsb=8 / vui-timing-info / vui-hrd-info / slices=1 / no-opt-qp-pps / no-opt-ref-list-length-pps / no-multi-pass-opt-rps / scenecut-bias=0.05 / no-opt-cu-delta-qp / no-aq-motion / no-hdr / no-hdr-opt / no-dhdr10-opt / no-idr-recovery-sei / analysis-reuse-level=5 / scale-factor=0 / refine-intra=0 / refine-inter=0 / refine-mv=0 / refine-ctu-distortion=0 / no-limit-sao / ctu-info=0 / no-lowpass-dct / refine-analysis-type=1901027772 / copy-pic=1 / max-ausize-factor=1.0 / no-dynamic-refine / no-single-sei / no-hevc-aq / no-svt / no-field / qp-adaptation-range=1.00
Default                                  : Yes
Forced                                   : No
Color range                              : Limited

Audio
ID                                       : 2
Format                                   : AAC LC
Format/Info                              : Advanced Audio Codec Low Complexity
Codec ID                                 : A_AAC-2
Duration                                 : 1 min 0 s
Bit rate                                 : 128 kb/s
Channel(s)                               : 2 channels
Channel layout                           : L R
Sampling rate                            : 44.1 kHz
Frame rate                               : 43.066 FPS (1024 SPF)
Compression mode                         : Lossy
Stream size                              : 22.9 MiB
Writing library                          : Lavc58.52.102 aac
Language                                 : Japanese
Default                                  : Yes
Forced                                   : No

Text
ID                                       : 3
Format                                   : ASS
Codec ID                                 : S_TEXT/ASS
Codec ID/Info                            : Advanced Sub Station Alpha
Duration                                 : 55 s 53 ms
Bit rate                                 : 199 b/s
Count of elements                        : 483
Compression mode                         : Lossless
Stream size                              : 36.5 KiB (0%)
Writing library                          : Lavc58.52.102 ssa
Language                                 : English
Default                                  : Yes
Forced                                   : No
        """.trimIndent()

        val h264Result = """
General
Complete name                            : random_sample_001.avi
Format                                   : AVI
Format/Info                              : Audio Video Interleave
Format profile                           : OpenDML
File size                                : 1.78 GiB
Duration                                 : 1 h 1 min
Overall bit rate                         : 4 155 kb/s
Writing application                      : ShanaEncoder
IsTruncated                              : Yes

Video
ID                                       : 0
Format                                   : AVC
Format/Info                              : Advanced Video Codec
Format profile                           : High@L4.1
Format settings                          : CABAC / 4 Ref Frames
Format settings, CABAC                   : Yes
Format settings, Reference frames        : 4 frames
Codec ID                                 : avc1
Duration                                 : 1 h 1 min
Bit rate                                 : 4 000 kb/s
Width                                    : 1 920 pixels
Height                                   : 1 080 pixels
Display aspect ratio                     : 16:9
Frame rate mode                          : Variable / VFR
Frame rate                               : 119.880 (24/30) FPS
Minimum frame rate                       : 23.976 FPS
Maximum frame rate                       : 29.970 FPS
Color space                              : YUV
Chroma subsampling                       : 4:2:0
Bit depth                                : 8 bits
Scan type                                : Progressive
Bits/(Pixel*Frame)                       : 0.016
Stream size                              : 1.71 GiB (96%)
Writing library                          : x264 core 142
Encoding settings                        : cabac=1 / ref=4 / deblock=1:0:0 / analyse=0x3:0x133 / me=umh / subme=10 / psy=1 / psy_rd=1.00:0.00 / mixed_ref=1 / me_range=24 / chroma_me=1 / trellis=2 / 8x8dct=1 / cqm=0 / deadzone=21,11 / fast_pskip=1 / chroma_qp_offset=-2 / threads=12 / lookahead_threads=2 / sliced_threads=0 / nr=0 / decimate=1 / interlaced=0 / bluray_compat=0 / constrained_intra=0 / bframes=8 / b_pyramid=2 / b_adapt=2 / b_bias=0 / direct=3 / weightb=1 / open_gop=0 / weightp=2 / keyint=250 / keyint_min=25 / scenecut=40 / intra_refresh=0 / rc_lookahead=60 / rc=2pass / mbtree=1 / bitrate=4000 / ratetol=1.0 / qcomp=0.60 / qpmin=0 / qpmax=69 / qpstep=4 / cplxblur=20.0 / qblur=0.5 / ip_ratio=1.40 / aq=1:1.00

Audio
ID                                       : 1
Format                                   : AC-3
Format/Info                              : Audio Coding 3
Commercial name                          : Dolby Digital
Codec ID                                 : 2000
Duration                                 : 1 h 1 min
Bit rate mode                            : Constant
Bit rate                                 : 1, 024 kb/s
Channel(s)                               : 2 channels
Channel layout                           : L R
Sampling rate                            : 44.1 kHz
Frame rate                               : 28.711 FPS (1536 SPF)
Bit depth                                : 16 bits
Compression mode                         : Lossy
Stream size                              : 56.0 MiB (3%)
Alignment                                : Aligned on interleaves
Interleave, duration                     : 35  ms (4.17 video frames)
Service kind                             : Complete Main
        """.trimIndent()
    }
}
