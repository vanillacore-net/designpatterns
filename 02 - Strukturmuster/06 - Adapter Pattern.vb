' Target interface
Public Interface IMediaPlayer
    Sub Play(filename As String)
End Interface

' Existing MP3 player
Public Class MP3Player
    Implements IMediaPlayer

    Public Sub Play(filename As String) Implements IMediaPlayer.Play
        Console.WriteLine("Playing MP3 file: " & filename)
    End Sub
End Class

' Modern player (Adaptee)
Public Class ModernPlayer
    Public Sub PlayMP4(filename As String)
        Console.WriteLine("Playing MP4 file: " & filename)
    End Sub
End Class

' Adapter
Public Class ModernPlayerAdapter
    Implements IMediaPlayer

    Private ReadOnly _modernPlayer As ModernPlayer

    Public Sub New(player As ModernPlayer)
        _modernPlayer = player
    End Sub

    Public Sub Play(filename As String) Implements IMediaPlayer.Play
        If filename.EndsWith(".mp4") Then
            _modernPlayer.PlayMP4(filename)
        Else
            Console.WriteLine("Invalid media format")
        End If
    End Sub
End Class

' Client code WITH pattern
Public Class ClientWithAdapter
    Public Shared Sub Main()
        Dim player As IMediaPlayer = New MP3Player()
        Dim modernPlayerAdapter As IMediaPlayer = New ModernPlayerAdapter(New ModernPlayer())

        ' Unified interface for all players
        player.Play("song.mp3")
        modernPlayerAdapter.Play("video.mp4")

        ' Can handle any player through the same interface
        PlayMedia("song.mp3", player)
        PlayMedia("video.mp4", modernPlayerAdapter)
    End Sub

    ' Can write methods that work with any player
    Public Shared Sub PlayMedia(filename As String, player As IMediaPlayer)
        player.Play(filename)
    End Sub
End Class

' Entry point
Module Program
    Sub Main()
        ClientWithAdapter.Main()
    End Sub
End Module